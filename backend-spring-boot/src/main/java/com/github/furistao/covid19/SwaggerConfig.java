package com.github.furistao.covid19;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // DocketはSpring Foxが提供するAPI。Swaggerで書き起こすために設定が必要
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select() // ApiSelector : Swaggerで書き起こすAPIを選択する。
                .apis(RequestHandlerSelectors.basePackage("com.github.furistao.covid19"))
                // .paths(PathSelectors.ant("/pets/**")) 指定パスに一致したものだけ表示
                .paths(PathSelectors.any()).build() // ApiSelectorを作成
                .useDefaultResponseMessages(false) // 定義していないステータスコードを自動で付与
                .apiInfo(apiInfo()) // APIのインフォメーションを設定
                .tags(new Tag("症例情報", "新型コロナウィルス COVID-19 の症例情報"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新型コロナウィルス症例情報")
                .description("新型コロナウィルスの症例情報 API")
                .version("1.0.0")
                .build();
    }
}