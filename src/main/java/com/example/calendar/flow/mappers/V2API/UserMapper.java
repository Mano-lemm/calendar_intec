package com.example.calendar.flow.mappers.V2API;

import com.example.calendar.model.dtos.v2api.UserGetResponse;
import com.example.calendar.model.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserGetResponse toGetResponse(User owner) {
        UserGetResponse ugr = new UserGetResponse(owner.getName());
        return ugr;
    }
}
