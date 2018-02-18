package com.workflow.common;

public interface WorkflowConstants {

    public enum DeaultValues{
        WORKFLOW_TYPE_ENTRY_STATUS("0"),
        WORKFLOW_TYPE_WORKLOW_STATUS("1"),;
        String value;

        DeaultValues(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public  int getIntValue(){
            return Integer.parseInt(value);
        }
    }
}
