///*
//package likedriving.design;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class RateLimiter {
//    public static void main(String args[]) {
//        System.out.println("Hello world - Java!");
//    }
//
//    private static Map<String, CustomRequestQueue> requestMap = null;
//
//    public boolean shouldThrottle(String ip) {
//        Long currentTimeStamp = System.currentTimeMillis();
//        if(requestMap != null){
//            if(requestMap.containsKey(ip)){
//                if(requestMap.get(ip).length < threshold){
//                    allowRequest = true;
//                }
//                else{
//                    if(requePstMap.get(ip).get(threshold).requestTimeStamp < currentTimeStamp - 60){
//                        allowRequest = true;
//                        requestMap.get(ip).get(threshold).remove(threshold);
//                    }
//                }
//            }else{
//                requestMap.put(ip, new CustomRequestQueue(currentTimeStamp));
//            }
//
//        }else{
//            requestMap = new HashMap<>();
//            requestMap.put(ip, new CustomRequestQueue(currentTimeStamp));
//        }
//
//        return false;
//    }
//
//}
//
//class CustomRequestQueue{
//    Queue<Long> requestTimeStamp = new LinkList<Long>;
//
//    public CustomRequestQueue(Long requestTimeStamp){
//        requestTimeStamp = requestTimeStamp;
//    }
//
//}
//
//
//
//
////
//*/
