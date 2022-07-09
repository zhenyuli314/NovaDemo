import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.*
import org.jooq.meta.jaxb.Configuration
import org.jooq.meta.jaxb.Target

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

}

group = "com.nova"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.jooq:jooq-codegen:3.14.7")
        classpath("mysql:mysql-connector-java:8.0.29")
    }
}


dependencies {

    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.projectlombok:lombok:1.18.20")
    runtimeOnly("mysql:mysql-connector-java:8.0.29")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.jooq:jooq:3.14.7")
    implementation("org.jooq:jooq-meta:3.14.7")
    implementation("org.jooq:jooq-codegen:3.14.7")

}

tasks.register("JOOQ_Code_Generate") {
    doLast{
        val config: Configuration = Configuration()
            .withJdbc(Jdbc()
                .withDriver("com.mysql.cj.jdbc.Driver")
                .withUrl("jdbc:mysql://127.0.0.1:3306/nova-demo?characterEncoding=UTF-8&serverTimezone=GMT")
                .withUsername("root")
                .withPassword("li15034395319"))
            .withGenerator(Generator()
                    //kotlin代码生成器，默认是java
                .withName("org.jooq.codegen.KotlinGenerator")
                .withGenerate(Generate()
                    .withSpringAnnotations(true) //spring的注解
                    .withComments(true) // 注释 √
                    .withCommentsOnCatalogs(true)
                    .withRelations(true)
                    .withImmutablePojos(false) // if true, cannot use 'into()' method
                    .withInterfaces(true) //接口，用于提高record和pojo之间的转化效率
                    .withDaos(true)) //生成 dao

                .withDatabase(Database()
                    .withName("org.jooq.meta.mysql.MySQLDatabase")//数据库类型
                    .withIncludes("nova_.*") //正则表达式，指定数据表
                    .withInputSchema("nova-demo") //指定数据库
                )
                .withTarget(
                    Target()//指定代码生成位置
                    .withPackageName("com.nova.novademo.codegen")
                    .withDirectory("src/main/kotlin"))
                .withStrategy(Strategy()
                    //自定义生成策略，报错
                    .withName("com.nova.novademo.jooqutil.CustomGeneratorStrategy")
//                    .withName("org.jooq.codegen.DefaultGeneratorStrategy")
                )
            )
        GenerationTool.generate(config)
    }
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
