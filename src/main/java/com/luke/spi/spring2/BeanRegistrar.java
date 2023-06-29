package com.luke.spi.spring2;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

public class BeanRegistrar implements ImportBeanDefinitionRegistrar, BeanClassLoaderAware {

    private ClassLoader beanClassLoader; //类加载器

    /**
     * BeanClassLoaderAware 接口起作用, 注入ClassLoader, 这里获取到的是: AppClassLoader
     * @param classLoader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println( "setBeanClassLoader:  " +  classLoader );
        this.beanClassLoader=classLoader;
    }

    /**
     * 使用 BeanDefinitionRegistry注册bean
     * @param annotationMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        //使用spring spi机制加载并注册bean
        List<String> classStringList = SpringFactoriesLoader.loadFactoryNames(Book.class, beanClassLoader);
        System.out.println( "loadedBeanClasses :  " + classStringList );

        //如果spring.factories文件为空得到的classStringList为空
        if (classStringList.isEmpty()) {
            return;
        }

        for (String classFullName : classStringList) {

            try {
                Class<?> clazz = beanClassLoader.loadClass(classFullName);
                String simpleName = clazz.getSimpleName();

                // 如果已经存在该 classFullName  的 BD
                if (registry.containsBeanDefinition(classFullName)) {
                    continue;
                }

                //创建bean封装对象
                BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(classFullName).getBeanDefinition();

                //将bean信息注册到容器
                registry.registerBeanDefinition(simpleName, beanDefinition);
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
