package com.example.demo.DataGetters;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.KeyValuePair;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;
import com.example.demo.Models.CattleModel;

import java.util.ArrayList;
import java.util.HashMap;

public class GetDataForWidgets {


//    public HashMap<String, Integer> getWeight(int numberOfIntervals, ArrayList<Cow> cows) {
//        Double lowest = 1000.0;
//        Double highest = 0.0;
//        for (Cow cow: cows) {
//            if (cow.getCurrentWeight() < lowest) {
//                lowest = cow.getCurrentWeight();
//            } else if (cow.getCurrentWeight() > highest) {
//                highest = cow.getCurrentWeight();
//            }
//        }
//        ArrayList<Integer> cowsPerInterval = new ArrayList<Integer>(numberOfIntervals);
//        for (Cow cow: cows) {
//            boolean found = false;
//            double interval = (highest - lowest) * (1/numberOfIntervals);
//            double lowBound = lowest;
//            double uppBound = lowest + interval;
//            int count = 0;
//            while (!found) {
//                if (cow.getCurrentWeight() >= lowBound && cow.getCurrentWeight() < uppBound) {
//                    cowsPerInterval.set(count, (int) cowsPerInterval.get(count) + 1);
//                    found = true;
//                }
//                lowBound += interval;
//                uppBound += interval;
//            }
//        }
//
//
//
//
//        double interval = (highest - lowest) * 0.2;
//        double current = lowest;
//        HashMap<String, Integer> data = new HashMap<String, Integer>();
//        int count = 0;
//        while (current < highest) {
//            data.put((int) current + "-" + (current + interval), (int) cowsPerInterval.get(count));
//            current += interval;
//            count += 1;
//        }
//        return data;
//    }

    public HashMap<String, Integer> getGenderData(ArrayList<Cow> cows) {
        Integer male = 0;
        Integer female = 0;
        for (Cow cow: cows) {
            if (cow.getGender() == Gender.MALE) {
                male += 1;
            } else {
                female += 1;
            }
        }
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Male", male);
        data.put("Female", female);
        return data;
    }

    public HashMap<String, Integer> getCategoryData(ArrayList<Cow> cows) {
        Integer bulls = 0;
        Integer steers = 0;
        Integer heifers = 0;
        Integer numCows = 0;
        for (Cow cow : cows) {
            if (cow.getCategory() == Category.BULL) {
                bulls += 1;
            } else if (cow.getCategory() == Category.STEER) {
                steers += 1;
            } else if (cow.getCategory() == Category.COW) {
                numCows += 1;
            }
                    else {
                heifers += 1;
            }
        }
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Bulls", bulls);
        data.put("Steers", steers);
        data.put("Cows", numCows);
        data.put("Heifers", heifers);
        return data;
    }
    public ArrayList<KeyValuePair> getAgeData(ArrayList<Cow> cows) {
        int oldestAge = 0;
        int lowestAge = 1000;
        ArrayList<Integer> numberPerYear = new ArrayList<Integer>();
        for (int i = 0; i < 100; i ++ ) {
            numberPerYear.add(0);
        }
        for (Cow cow: cows) {
            numberPerYear.set(cow.getAge(), numberPerYear.get(cow.getAge()) + 1);
            if (cow.getAge() > oldestAge) {
                oldestAge = cow.getAge();
            }
            if (cow.getAge() < lowestAge) {
                lowestAge = cow.getAge();
            }
        }
//        HashMap<String, Number> data = new HashMap<>();
        ArrayList<KeyValuePair> data = new ArrayList<>();
        int count = 0;
        for (int value: numberPerYear) {
            if (count >= lowestAge && count <= oldestAge) {
                data.add(new KeyValuePair("" + count, value));
            }
            count += 1;
        }
        return data;
    }
    public ArrayList<KeyValuePair> getWeightData(ArrayList<Cow> cows) {
        double highestWeight = 0;
        double lowestWeight = 1000;
        ArrayList<Integer> numberPerWeight = new ArrayList<Integer>();
        int noData = 0;
        for (int i = 0; i < 100; i ++ ) {
            numberPerWeight.add(0);
        }
        for (Cow cow: cows) {
            if (cow.getCurrentWeight() == -1) {
                noData += 1;
            } else if (cow.getCurrentWeight() < 100) {
                numberPerWeight.set(0, numberPerWeight.get(0) + 1);
            } else if (cow.getCurrentWeight() < 200) {
                numberPerWeight.set(1, numberPerWeight.get(1) + 1);
            } else if (cow.getCurrentWeight() < 300) {
                numberPerWeight.set(2, numberPerWeight.get(2) + 1);
            } else if (cow.getCurrentWeight() < 400) {
                numberPerWeight.set(3, numberPerWeight.get(3) + 1);
            } else if (cow.getCurrentWeight() < 500) {
                numberPerWeight.set(4, numberPerWeight.get(4) + 1);
            } else if (cow.getCurrentWeight() < 600) {
                numberPerWeight.set(5, numberPerWeight.get(5) + 1);
            } else if (cow.getCurrentWeight() < 700) {
                numberPerWeight.set(6, numberPerWeight.get(6) + 1);
            } else if (cow.getCurrentWeight() < 800) {
                numberPerWeight.set(7, numberPerWeight.get(7) + 1);
            } else if (cow.getCurrentWeight() < 900) {
                numberPerWeight.set(8, numberPerWeight.get(8) + 1);
            } else if (cow.getCurrentWeight() < 1000) {
                numberPerWeight.set(9, numberPerWeight.get(9) + 1);
            } else if (cow.getCurrentWeight() < 1100) {
                numberPerWeight.set(10, numberPerWeight.get(10) + 1);
            } else if (cow.getCurrentWeight() < 1200) {
                numberPerWeight.set(11, numberPerWeight.get(11) + 1);
            } else if (cow.getCurrentWeight() < 1300) {
                numberPerWeight.set(12, numberPerWeight.get(12) + 1);
            } else if (cow.getCurrentWeight() < 1400) {
                numberPerWeight.set(13, numberPerWeight.get(13) + 1);
            } else if (cow.getCurrentWeight() < 1500) {
                numberPerWeight.set(14, numberPerWeight.get(14) + 1);
            } else if (cow.getCurrentWeight() < 1600) {
                numberPerWeight.set(15, numberPerWeight.get(15) + 1);
            } else if (cow.getCurrentWeight() < 1700) {
                numberPerWeight.set(16, numberPerWeight.get(16) + 1);
            } else if (cow.getCurrentWeight() < 1800) {
                numberPerWeight.set(17, numberPerWeight.get(17) + 1);
            } else if (cow.getCurrentWeight() < 1900) {
                numberPerWeight.set(18, numberPerWeight.get(18) + 1);
            } else if (cow.getCurrentWeight() < 2000) {
                numberPerWeight.set(19, numberPerWeight.get(19) + 1);
            } else if (cow.getCurrentWeight() < 2100) {
                numberPerWeight.set(20, numberPerWeight.get(20) + 1);
            } else if (cow.getCurrentWeight() < 2200) {
                numberPerWeight.set(21, numberPerWeight.get(21) + 1);
            } else if (cow.getCurrentWeight() < 2300) {
                numberPerWeight.set(22, numberPerWeight.get(22) + 1);
            } else if (cow.getCurrentWeight() < 2400) {
                numberPerWeight.set(23, numberPerWeight.get(23) + 1);
            } else if (cow.getCurrentWeight() < 2500) {
                numberPerWeight.set(24, numberPerWeight.get(24) + 1);
            } else if (cow.getCurrentWeight() < 2600) {
                numberPerWeight.set(25, numberPerWeight.get(25) + 1);
            } else if (cow.getCurrentWeight() < 2700) {
                numberPerWeight.set(26, numberPerWeight.get(26) + 1);
            } else if (cow.getCurrentWeight() < 2800) {
                numberPerWeight.set(27, numberPerWeight.get(27) + 1);
            } else if (cow.getCurrentWeight() < 2900) {
                numberPerWeight.set(28, numberPerWeight.get(28) + 1);
            } else if (cow.getCurrentWeight() < 3000) {
                numberPerWeight.set(29, numberPerWeight.get(29) + 1);
            } else if (cow.getCurrentWeight() < 3100) {
                numberPerWeight.set(30, numberPerWeight.get(30) + 1);
            }
//            numberPerWeight.set(cow.getAge(), numberPerYear.get(cow.getAge()) + 1);
            if (cow.getCurrentWeight() > highestWeight) {
                highestWeight = cow.getCurrentWeight();
            }
            if (cow.getCurrentWeight() < lowestWeight) {
                lowestWeight = cow.getCurrentWeight();
            }
        }
        ArrayList<KeyValuePair> data = new ArrayList<>();
        int count = 0;
        if (noData != 0) {
            data.add(new KeyValuePair("No data", noData));
        }
        for (int value: numberPerWeight) {
            if (count * 100 >= lowestWeight && count * 100 <= highestWeight) {
                data.add(new KeyValuePair("" + count * 100, value));
            }
            count += 1;
        }
        return data;
    }


}
