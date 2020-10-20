# Spring Boot に Swagger を導入する方法
Spring Fox を追加するだけで良い。ただし、そのままでは不要な記載も表示されてしまうので、Swagger の設定を行う。

## Spring Fox を追加する
Spring Boot アプリに Swagger（Open API）を表示させるには、依存関係に Spring Fox を追加するだけで良い。

build.gradle の dependencies に Spring Fox を追加する。
```java
dependencies {
	implementation 'io.springfox:springfox-boot-starter:3.0.0'
}
```

## basic-error-controller を消したい
![](./want_to_delete_displaying_basic_error-controller.png)
