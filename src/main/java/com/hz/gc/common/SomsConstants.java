package com.hz.gc.common;

/**
 *  常量枚举类
 */
public interface SomsConstants {

    /**
     * 设备状态枚举值
     * code码
     * 0,禁用
     * 1,启用
     */

    public enum DeviceConstants {

        DEVICE_STATE_DISABLE(0, "禁用状态"),
        DEVICE_STATE_ENABLE(1, "启动状态");


        private Integer code;

        private String msg;

        DeviceConstants(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public Integer getCode() {
            return code;
        }
    }


    /**
     * 操作结果枚举值
     *  code码
     *  0,成功
     *  1,失败
     */

    public enum DeviceOperationConstants {

        OPERATION_RESULT_SUCCESS(0,"成功"),
        OPERATION_RESULT_FAILURE(1,"失败");

        private Integer code;
        private String msg;

        DeviceOperationConstants(Integer code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
    /**
     * 设备状态枚举值
     * code码
     * 0,禁用
     * 1,启用
     */

    public enum OrchardConstants{

        ORCHARD_STATE_DISABLE(0,"禁用"),
        ORCHARD_STATE_ENABLE(1,"启用");

        private Integer code;
        private String msg;

        OrchardConstants(Integer code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

    }

    /**
     * 计划优先级枚举值
     * code码
     * 0,任务优先级为低
     * 1,任务优先级为中
     * 2,任务优先级为高
     */
    public enum PlanConstants{

        PLAN_LEVEL_LOW_LEVEL(0,"任务优先级为低"),
        PLAN_LEVEL_MIDDLE_LEVEL(1,"任务优先级为中"),
        PLAN_LEVEL_HIGH_LEVEL(2,"任务优先级为高");

        private Integer code;
        private String msg;

        PlanConstants(Integer code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 视频设备的状态
     * 1 启用
     * 0 禁用
     *
     * 视频设备的类型
     * 枪机,球机.
     */
    public enum VideoConstants{

        VIDEO_STATE_ENABLE(1,"启用"),
        VIDEO_STATE_DISABLE(0,"禁用"),
        VIDEO_TYPE_QIANG_JI("枪机"),
        VIDEO_TYPE_QIU_JI("球机");


        private Integer code;
        private String msg;

        VideoConstants(String msg){
            this.msg = msg;
        }
        VideoConstants(Integer code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 设备报警触发类型
     *  0 邮件
     *  1 短信
     *
     *  设备报警触发方式
     *  0 故障原因
     *  1 设备阈值
     */
    public enum DeviceWarnRecord{

        DEVICE_WARN_WAY_EMAIL(0,"邮件"),
        DEVICE_WARN_WAY_MOBILE(1,"电话"),
        DEVICE_WARN_TYPE_FAULT(0,"因故障报警"),
        DEVICE_WARN_TYPE_THRESHOLD_VALUE(1,"因设备阈值报警");

        private Integer code;
        private String msg;

        DeviceWarnRecord(Integer code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     *  权限类型
     *  0 菜单
     *  1 按钮
     */
    public enum PermissionConstants{

            PERMISSION_TYPE_MENU(0,"菜单"),
            PERMISSION_TYPE_button(1,"按钮");

            private Integer code;
            private String msg;

            PermissionConstants(Integer code,String msg){
                this.code = code;
                this.msg = msg;
            }

            public Integer getCode() {
                return code;
            }

            public String getMsg() {
                return msg;
            }
    }

    /**
     *  用户账号状态
     *  0 启用
     *  1 禁用
     *
     *
     *  用户性别
     *
     *  0 女
     *  1 男
     */
    public enum UserConstants{

            USER_STATE_ENABLE(0,"启用"),
            USER_STATE_DISABLE(1,"禁用"),
            USER_SEX_MAN(0,"女"),
            USER_SEX_WOMEN(1,"男");

            private Integer code;
            private String msg;

            UserConstants(Integer code,String msg){
                this.code = code;
                this.msg = msg;
            }

            public Integer getCode() {
                return code;
            }

            public String getMsg() {
                return msg;
            }
    }
}
