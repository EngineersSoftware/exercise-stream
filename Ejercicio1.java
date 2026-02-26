import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio1 {

    public static void main(String[] args) {

        // filter() - intermedia - filtrar elementos segun una condicion
        // map() - intermedia - transformar cada elemento
        // sorted() - intermedia - ordenar elementos
        // forEach() - terminal - realizar una accion para cada elemento
        // collect() - terminal - recolectar elementos en una coleccion (List, Set)
        // reduce() - terminal - combinar elementos para obtener un resultado unico (suma,producto)
        
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Juan", "Ventas", 50000),
                new Empleado("María", "Marketing", 60000),
                new Empleado("Pedro", "Ventas", 55000),
                new Empleado("Ana", "RRHH", 52000)
        );

        // FILTRAR: Empleados con salario mayor a 3000
        System.out.println("---- Empleados con salario mayor a 3000 ----");
        empleados.stream().filter(e  -> e.salario > 3000).forEach(System.out::println);

        // Tranformar: Obtener solos nombres en MAYUSCULAS
        System.out.println("---- Nombres en MAYUSCULAS ----");
        List<String> nombresMayus = empleados.stream()
                    .map(e -> e.nombre.toUpperCase())
                    .collect(Collectors.toList());
                    System.out.println(nombresMayus);
        
        
        //  Ordenar: Por salario de mayor a menor
        System.out.println("---- Empleados ordenados por salario (mayor a menor) ----");
        empleados.stream()
                .sorted(Comparator.comparingDouble((Empleado e) -> e.salario).reversed())
                .forEach(System.out::println);

        
        // Reducir: Calcular el total de salarios
        System.out.println("---- Total de salarios ----");
        double totalSalarios = empleados.stream()
                .mapToDouble(e -> e.salario).sum();
        System.out.println("Total de salarios: " + totalSalarios);

        // Agrupar: Empleados por departamentos
        System.out.println("---- Empleados agrupados por departamento ----");
        Map<String, List<Empleado>> porDepto = empleados.stream()
                                                         .collect(Collectors.groupingBy(e -> e.departamento));
                                        
                                                         porDepto.forEach((depto, lista) -> {
                                                            System.out.println(depto + ": " + lista);
                                                         });

    }
}