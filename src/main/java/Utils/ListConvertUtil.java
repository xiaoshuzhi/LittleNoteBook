package Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ListConvertUtil {
    public static <T,E> List<T> getList(String method, List<E> list) {
        String methodName = "get" + method;
        ArrayList<T> arrayList = new ArrayList<T>();
        for (E itemn : list) {
            Method[] methods = itemn.getClass().getMethods();
            List<Method> methodList = Arrays.asList(methods);
            methodList.stream().filter(item->item.getName().toLowerCase().equals(methodName.toLowerCase())).forEach(item->{
                try {
                    arrayList.add((T)item.invoke(itemn));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }
        return arrayList ;
    }

    public static <T,E> List<Map<String,Object>> gettest (String methodName, List<T> allList, List<E> singalList){
        List<Map<String, Object>> datas = new ArrayList<>();
        allList.stream().forEach(item->{
            try {
                Method med = item.getClass().getMethod(methodName);
                E val = (E) med.invoke(item);
                Map<String, Object> data = new HashMap<>();
                data.put("data1", item);
                if (singalList.contains(val)) {
                    data.put("flag", 1);
                }else{
                    data.put("flag", 0);
                }
                datas.add(data);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return datas;
    }
}
