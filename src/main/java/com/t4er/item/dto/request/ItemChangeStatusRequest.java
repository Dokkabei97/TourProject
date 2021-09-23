package com.t4er.item.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemChangeStatusRequest {

    private String itemToken;

}
