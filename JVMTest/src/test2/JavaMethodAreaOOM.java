package test2;

import test2.HeapOOM.OOMObject;

/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author liyajun
 *
 */
public class JavaMethodAreaOOM {
	public static void main(String[] args){
		while(true){
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperClass(FileHeap.class);
//			enahncer.setUseCache(false);
//			enhancer.setCallback(new MethodInterceptor(){
//				public Object interceptor(Object obj, Method method, Object[] args, MethodProxy proxy)throws Throwable{
//					return proxy.invokeSuper(obj.args);
//				}
//			});
//			enhancer.create();
		}
	}
	
	static class OOMObject{
		
	}
}
