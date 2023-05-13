package com.cdu.SoulMate.model.request;

import com.cdu.SoulMate.common.PageRequest;
import lombok.Data;

/**
 * @author luokunsong
 * @Date: 2023年03月13日 09:46
 * @Version: 1.0
 * @Description:
 */
@Data
public class UserSearchRequest extends PageRequest {
    private static final long serialVersionUID = 5579195046213219475L;
    private String username;
}
