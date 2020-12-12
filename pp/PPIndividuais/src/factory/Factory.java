/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import persistencia.TMPersist;

/**
 *
 * @author vovomint
 */
public class Factory {

    public static TMPersist getOrdenador(String className, String fileName) throws Exception {
        return (TMPersist) Class.forName("persistencia." + className).getConstructor(String.class).newInstance(fileName);
    }
}
