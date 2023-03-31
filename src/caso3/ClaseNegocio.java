package caso3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClaseNegocio {
    public static void devolverBaldosas(double area, List<Double>baldosas)
    {
        double areaOriginal= area;
        Map<Double,Integer>baldosasH=new HashMap<>();
        //Crear Cuadrado
        boolean encontrado= false;
        for(int i=0;i<baldosas.size()&&!encontrado&&area>0;i++)
        {
            double baldosa= baldosas.get(i);
            if(area>=baldosa){
                int veces=(int)(area/baldosa);
                baldosasH.put(baldosa, veces);
                area=area%baldosa;
                encontrado=true;
            }
        }
        // Rellenar
        for(int i=0;i<baldosas.size()&&!encontrado&&area>0;i++){
            double baldosa= baldosas.get(i);
            if(area>=baldosa){
                int veces=(int)((area/baldosa*areaOriginal/baldosa)+(area/baldosa*(areaOriginal-area)/baldosa));
                baldosasH.put(baldosa, veces);
                area=area%baldosa;
            }
        }
        
        baldosasH.forEach((key, value) -> System.out.println(key+" "+value));
        if(area>0)
            System.out.println("no se puede");
    }
}
