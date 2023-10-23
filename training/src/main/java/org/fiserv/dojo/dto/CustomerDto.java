package org.fiserv.dojo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    @NotBlank(message = "Firstname should not be blank")
    private String FirstName;
    private String LastName;
    private String Address;
}
