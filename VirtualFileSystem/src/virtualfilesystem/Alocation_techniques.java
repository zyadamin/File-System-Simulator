/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualfilesystem;

import java.util.ArrayList;

/**
 *
 * @author Manar Atef
 */
public interface Alocation_techniques {
 
    public File Allocation(int disk[],String name,int size);
    public void DeAllocation(File file,int disk[]);
}
