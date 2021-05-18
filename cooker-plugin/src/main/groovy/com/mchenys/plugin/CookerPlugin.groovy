package com.mchenys.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class CookerPlugin implements Plugin<Project> {

    void apply(Project project) {
        println "这里实现plugin的逻辑!"

        // 关联扩展属性,别名是pluginExt, 对应的类是PluginExtension
        project.extensions.create('pluginExt', PluginExtension)
        // 关联pluginExt属性的嵌套属性,别名是nestExt,对应的类是PluginNestExtension
        project.pluginExt.extensions.create('nestExt', PluginNestExtension)
        // 关联自定义任务,别名是customTask, 对应的类是CustomTask
        project.task('customTask', type: CustomTask)

        project.task('cooker-test-task').doLast { variant ->
            println "自定义任务-doLast"
        }.doFirst { variant ->
            println "自定义任务-doFirst"
        }
    }
}