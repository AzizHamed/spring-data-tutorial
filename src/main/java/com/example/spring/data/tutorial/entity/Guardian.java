package com.example.spring.data.tutorial.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "firstName",
                column = @Column(name = "guardian_first_name")),

        @AttributeOverride(name = "lastName",
                column = @Column(name = "guardian_last_name")),

        @AttributeOverride(name = "email",
                column = @Column(name = "guardian_email"))


})
public class Guardian {

    private String firstName;

    private String lastName;

    private String email;
}
