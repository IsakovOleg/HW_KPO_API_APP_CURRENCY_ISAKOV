package org.hse.template.jdbc

import io.swagger.v3.oas.annotations.media.Schema
import org.hse.template.api.FooApi
import org.hse.template.client.rest.api.Currency
import org.hse.template.client.rest.model.Curr
import org.hse.template.client.rest.model.AllCurr
import org.hse.template.client.rest.model.HistCurr
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.DriverManager
import org.springframework.context.annotation.Configuration

@Configuration
class Jdbc {
    fun hist(a: String) : Boolean {
        val connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hse_sc", "postgres", "postgres")
        connection.createStatement().use { stmt ->
            val query = "SELECT all FROM history"
            stmt.executeQuery(query).use { rs ->
                while (rs.next()) {
                    val type = rs.getString("type")
                    if (a.equals(type)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}