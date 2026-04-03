package edu.mcc.codeschool.class25.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Evan Stohlmann",
                        email = "esstohlmann@mccneb.edu",
                        url = "https://www.mccneb.edu/community-business/workforce-education/programs-and-certifications/information-technology-career-training/mcc-code-school"
                ),
                title = "Tic-Tac-Toe Application",
                description = "This is the doc site for the MCC tic-tac-toe management API system",
                version = "1.0"
        )
)
public class OpenAPIConfig {
}
