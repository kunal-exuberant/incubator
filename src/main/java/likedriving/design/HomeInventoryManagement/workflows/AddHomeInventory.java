package likedriving.design.HomeInventoryManagement.workflows;

import likedriving.design.HomeInventoryManagement.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddHomeInventory {

    public static List<Item> addHomeInventory(){

        Scanner scanner = new Scanner(System.in);
        Item item;
        List<Item> items = new ArrayList<>();

        int itemId = 1;
        System.out.print("Input inventory "+itemId+": ");
       do{
            String inputItem = scanner.next();
            if(inputItem.equals("done")){
                for(Item item1: items){
                    System.out.println(item1.getName());
                }
                break;
            }
            item = new Item();
            item.setName(inputItem);
            item.setId(itemId);
            itemId++;

           items.add(item);
           System.out.println();
           System.out.print("Input inventory "+itemId+": ");
        }while (scanner.hasNext());

       return items;
    }

    public static void main(String[] args) {
        List<Item> items = addHomeInventory();
        Consumption consumption = addConsumption(items);
        Stock stock = newStockInboarding(items);
        Map<Item, Integer> report = new Report().generateReport(items, consumption, stock);

        System.out.println();
        System.out.println("Generating report ...");
        for(Map.Entry<Item, Integer> reportItem: report.entrySet()){
            System.out.println(reportItem.getKey()+": "+reportItem.getValue());
        }
    }

    public static Stock newStockInboarding(List<Item> items){

        Stock stock = new Stock();
        Quantity quantity;
        System.out.println();
        for(Item item: items){
            System.out.print("Add stocks for "+item.getName()+": ");
            Scanner sc = new Scanner(System.in);
            quantity = new Quantity(Integer.parseInt(sc.next()), Units.KG);
            stock.getStocksPerItem().put(item, quantity);
        }
        return stock;
    }

    public static Consumption addConsumption(List<Item> items){

        Consumption consumption = new Consumption();

        Quantity quantity;
        System.out.println();
        for(Item item: items){
            System.out.print("Add consumption for "+item.getName()+": ");
            Scanner sc = new Scanner(System.in);
            quantity = new Quantity(Integer.parseInt(sc.next()), Units.KG);
            consumption.getConsumptionPerConsumer().put(item, quantity);
        }
        return consumption;
    }


}
