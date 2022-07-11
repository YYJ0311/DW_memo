```
1. build.gradle 에 다음 추가
    plugins{
        id 'war'
    }

    bootWar{
        archiveBaseName= '프로젝트명'
        archiveFileName= '프로젝트명.war'
        archiveVersion= '0.0.1'
    }
    
    dependencies {
        providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    }

2. Application
    2-1. 상속
        extends SpringBootServletInitializer
    2-2. 오버라이드
    	@Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(SpringApplication.class);
        }

3. gradle tasks
    이클립스 재접속
    clean하고 bootWar 
```