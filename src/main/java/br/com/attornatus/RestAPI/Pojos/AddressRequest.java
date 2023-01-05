package br.com.attornatus.RestAPI.Pojos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {
    private int addressID;
    private String street;
    private String postCode;
    private String number;
    private String city;
    private Boolean isMainAddress;
    private int people_id;
}
