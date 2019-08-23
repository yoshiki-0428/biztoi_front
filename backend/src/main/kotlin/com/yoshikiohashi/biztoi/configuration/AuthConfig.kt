package com.yoshikiohashi.biztoi.configuration

import com.yoshikiohashi.biztoi.filter.AuthFilter
import com.nimbusds.jose.proc.SecurityContext
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

/**
 * Configuration for web security
 */
@EnableWebSecurity
class AuthConfig(val processor: ConfigurableJWTProcessor<SecurityContext>) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(AuthFilter(processor, authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
                .cors()
                .configurationSource(corsConfigurationSource())
    }

    /**
     * CORS設定
     *
     * @return CORS設定
     */
    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)
        corsConfiguration.addAllowedOrigin("http://localhost:3000")
        corsConfiguration.setAllowCredentials(true)

        val corsConfigurationSource: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsConfigurationSource
    }
}
