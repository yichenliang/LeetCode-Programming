plugins {
    java
}

repositories {
    jcenter()
}

tasks.test {
    useJUnitPlatform()
    maxHeapSize = "1G"
    filter{
        includeTestsMatching("yichenliang.leetcode.*")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}

dependencies {
    implementation("com.google.guava:guava:26.0-jre")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.4.0")
}
