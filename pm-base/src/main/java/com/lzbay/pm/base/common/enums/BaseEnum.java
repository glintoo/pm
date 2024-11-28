package com.lzbay.pm.base.common.enums;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Objects;

public interface BaseEnum {
    Object getValue();

    String getDesc();

    default boolean equalsValue(Object value) {
        return Objects.equals(getValue(), value);
    }

    default boolean equals(BaseEnum baseEnum){
        return Objects.equals(getValue(), baseEnum.getValue()) && Objects.equals(getDesc(), baseEnum.getDesc());
    }

    static String getInfo(Class<? extends BaseEnum> clazz){
        BaseEnum[] enums = clazz.getEnumConstants();
        LinkedHashMap<String, JSONObject> map = new LinkedHashMap<>(enums.length);
        for(BaseEnum e: enums){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", new DeleteQuotationAware(e.getValue()));
            jsonObject.put("desc", new DeleteQuotationAware(e.getDesc()));
            map.put(e.toString(), jsonObject);
        }

        String enumJSON = JSONObject.toJSONString(map, true);
        enumJSON = enumJSON.replaceAll("\"","");
        enumJSON = enumJSON.replaceAll("\t","&nbsp;&nbsp;");
        enumJSON = enumJSON.replaceAll("\n","<br/>");
        String prefix = "  <br/>  export const " + CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE,
                clazz.getSimpleName() + " = <br/> ");
        return prefix + enumJSON + "<br/>";
    }

    @Data
    class DeleteQuotationAware implements JSONAware {
        private String value;

        public DeleteQuotationAware(Object value) {
            if (value instanceof String) {
                this.value = (String) value;
            }else {
                this.value = value.toString();
            }
        }

        @Override
        public String toJSONString() {
            return value;
        }
    }
}
