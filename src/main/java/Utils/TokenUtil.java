package Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


import javax.crypto.Mac;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TokenUtil {

    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TokenUtil.class);

    public static String createToken(String username,String uid,String secret,long aliveTime) {
        Map<String,Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withHeader(header)
                    .withExpiresAt(new Date(System.currentTimeMillis() + aliveTime))
                    .withClaim("username", username)
                    .withClaim("uid",uid)
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            logger.error("JWTCreationException:");
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        if (!token.equals("")) {
            logger.info("生成token 成功:" +token);
        }else{
            logger.error("生成token失败:");
        }
        return token;
    }

    public static String createTokenCode(String email,String secret,long aliveTime) {
        Map<String,Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withHeader(header)
                    .withExpiresAt(new Date(System.currentTimeMillis() + aliveTime))
                    .withClaim("email", email)
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            logger.error("JWTCreationException:");
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        if (!token.equals("")) {
            logger.info("生成token 成功:" +token);
        }else{
            logger.error("生成token失败:");
        }
        return token;
    }

    public static Map<String,Object> valid(String token,String secret){
        Map<String,Object> data = new HashMap<>();
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            long expTime = jwt.getExpiresAt().getTime();
            long nowTime = new Date(System.currentTimeMillis()).getTime();
            data.put("Result",GlobalValue.TOKEN_VALIDATE_MESSAGE);
            data.put("username", jwt.getClaim("username").asString());
            data.put("uid", jwt.getClaim("uid").asString());
            if(expTime-nowTime<5*60*1000){
                data.put("Result", GlobalValue.TOKEN_NEED_REFRESH_MESSAGE);
            }
        } catch (JWTVerificationException exception){
            data.clear();
            data.put("Result",GlobalValue.ILLEGAL_TOKEN_MESSAGE);//超时或者非法token
            //Invalid signature/claims
        }
        return data;

    }

    public static Map<String,Object> validPassword(String token,String secret){
        Map<String,Object> data = new HashMap<>();
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            long expTime = jwt.getExpiresAt().getTime();
            long nowTime = new Date(System.currentTimeMillis()).getTime();
            data.put("Result",GlobalValue.TOKEN_VALIDATE_MESSAGE);
            data.put("username", jwt.getClaim("username").asString());
            data.put("uid", jwt.getClaim("uid").asString());
        } catch (JWTVerificationException exception){
            data.clear();
            data.put("Result",GlobalValue.ILLEGAL_TOKEN_MESSAGE);//超时或者非法token
            //Invalid signature/claims
        }
        return data;
    }

    public static Map<String,Object> validCode(String token,String secret){
        Map<String,Object> data = new HashMap<>();
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            long expTime = jwt.getExpiresAt().getTime();
            long nowTime = new Date(System.currentTimeMillis()).getTime();
            data.put("Result",GlobalValue.TOKEN_VALIDATE_MESSAGE);
            data.put("email", jwt.getClaim("email").asString());
        } catch (JWTVerificationException exception){
            data.clear();
            data.put("Result",GlobalValue.ILLEGAL_TOKEN_MESSAGE);//超时或者非法token
            //Invalid signature/claims
        }
        return data;
    }
}

//        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
//        Payload payload = new Payload(new JSONObject(payloadMap));
//        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
//        logger.info(secret.length+"");
//        try {
//            JWSSigner jwsSigner= new MACSigner(secret);
//            jwsObject.sign(jwsSigner);
//        } catch (KeyLengthException e) {
//            logger.error(secret+":KeyLengthException");
//            e.printStackTrace();
//        } catch (JOSEException e) {
//            logger.error(secret+":JOSEException");
//            e.printStackTrace();
//        }
//        return jwsObject.serialize();


//        JWSObject jwsObject = null;
//        try {
//            jwsObject = JWSObject.parse(token);
//        } catch (ParseException e) {
//            logger.error(token+ ":ParseException");
//            e.printStackTrace();
//        }
//
//        //获取到载荷
//        Payload payload=jwsObject.getPayload();
//
//        //建立一个解锁密匙
//        JWSVerifier jwsVerifier = null;
//        try {
//            jwsVerifier = new MACVerifier(secret);
//        } catch (JOSEException e) {
//            logger.error(secret+ ":JOSEException");
//            e.printStackTrace();
//        }
//
//        Map<String, Object> resultMap = new HashMap<>();
//        //判断token
//        try {
//            if (jwsObject.verify(jwsVerifier)) {
//                resultMap.put("Result", GlobalValue.TOKEN_VALIDATE);
//                //载荷的数据解析成json对象。
//                JSONObject jsonObject = payload.toJSONObject();
//                resultMap.put("data", jsonObject);
//
//                //判断token是否过期
//                if (jsonObject.containsKey("exp")) {
//                    Long expTime = Long.valueOf(jsonObject.get("exp").toString());
//                    Long nowTime = new Date().getTime();
//                    //判断是否过期
//                    logger.info("nowTime",nowTime);
//                    logger.info("expTime",expTime);
//                    if (nowTime > expTime) {
//                        //已经过期
//                        resultMap.clear();
//                        resultMap.put("Result", GlobalValue.TOKEN_OUT_TIME);
//                    }else if((expTime/1000)-(nowTime/1000)<60*5){
//                        resultMap.put("Result", GlobalValue.TOKEN_NEED_REFRESH);
//                    }
//                }
//            }else {
//                resultMap.put("Result", GlobalValue.TOKEN_OUT_TIME);
//            }
//        } catch (JOSEException e) {
//            logger.error(jwsVerifier+ ":JOSEException");
//            e.printStackTrace();
//        }
//        return resultMap;