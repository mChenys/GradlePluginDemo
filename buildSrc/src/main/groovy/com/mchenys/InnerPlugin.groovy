package com.mchenys

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 在buildSrc工程内自定义内置插件
 */
class InnerPlugin implements Plugin<Project> {

    void apply(Project project) {
        println "InnerPlugin run...."
        project.task('helloInnerPluginTask', group: 'cys'){
            doFirst {
                println "helloInnerPluginTask run..."
            }
        }
    }
}