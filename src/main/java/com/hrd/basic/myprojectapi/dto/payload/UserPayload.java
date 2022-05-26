package com.hrd.basic.myprojectapi.dto.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**********************************************************************
 * Original Author: Huot Chansreynich
 * Created Date: 12/07/2021
 * Development Group: HRD Group
 * Description: UserPayload Class
 **********************************************************************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {
    private String id;
    private String username;
    private String email;
    private String status;
}
