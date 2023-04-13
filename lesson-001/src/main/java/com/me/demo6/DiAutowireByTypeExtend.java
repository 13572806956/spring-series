package com.me.demo6;

import java.util.List;
import java.util.Map;

/**
 * 满足条件的bean注入到集合中(重点)
 */
public class DiAutowireByTypeExtend {

    //定义了一个接口
    public interface IService1 {
    }

    public static class BaseService {

        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "BaseService{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    //Service1实现了IService1接口
    public static class Service1 extends BaseService implements IService1 {
    }

    //Service1实现了IService1接口
    public static class Service2 extends BaseService implements IService1 {
    }

    private List<IService1> serviceList;//@1
    private List<BaseService> baseServiceList;//@2
    private Map<String, IService1> service1Map;//@3
    private Map<String, BaseService> baseServiceMap;//@4

    public List<IService1> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<IService1> serviceList) {//@5
        this.serviceList = serviceList;
    }

    public List<BaseService> getBaseServiceList() {
        return baseServiceList;
    }

    public void setBaseServiceList(List<BaseService> baseServiceList) {//@6
        this.baseServiceList = baseServiceList;
    }

    public Map<String, IService1> getService1Map() {
        return service1Map;
    }

    public void setService1Map(Map<String, IService1> service1Map) {//@7
        this.service1Map = service1Map;
    }

    public Map<String, BaseService> getBaseServiceMap() {
        return baseServiceMap;
    }

    public void setBaseServiceMap(Map<String, BaseService> baseServiceMap) {//@8
        this.baseServiceMap = baseServiceMap;
    }

    @Override
    public String toString() { //9
        return "DiAutowireByTypeExtend{" +
                "serviceList=" + serviceList +
                ", baseServiceList=" + baseServiceList +
                ", service1Map=" + service1Map +
                ", baseServiceMap=" + baseServiceMap +
                '}';
    }
}
