package com.zzs;

import lombok.Data;

/**
 * @author mm013
 * @Date 2021/3/3 16:52
 */
@Data
public class MsgEntity {
    private String msgId;
    private String userId;
    private String phone;
    private String email;

    public MsgEntity(String msgId, String userId, String phone, String email) {
        this.msgId = msgId;
        this.userId = userId;
        this.phone = phone;
        this.email = email;
    }
}
