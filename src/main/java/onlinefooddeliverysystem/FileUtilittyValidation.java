package onlinefooddeliverysystem;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service
public class FileUtilittyValidation {
    public Boolean CategoryFileFormat(Row headerRow) {
        Boolean matched = true;
        String errorMsg = "";


        for (int i = 0; i < 3; i++) {
            Cell cell = headerRow.getCell(i);
            errorMsg = (cell == null || cell.getCellType() == CellType.BLANK) ? "file upload error due to row no " + i + 1 + " is empty" : "";

            if (errorMsg.isEmpty() && matched == true) {

                //        System.out.println("Header value" + cell.toString() + "\n");
                String cellName = cell.toString();
                switch (cellName) {
                    /*case "categoryId":
                        matched = true;
                        break;*/
                    case "categoryName":
                        matched = true;
                        break;
                    case "categoryDescription":
                        matched = true;
                        break;
                    case "action":
                        matched = true;
                        break;
                    default:
                        matched = false;
                        break;


                }
            } else {
                matched = false;
            }
        }

        return matched;

    }

    public Boolean FoodFileFormat(Row headerRow) {
            Boolean matched = true;
            String errorMsg = "";


            for (int i = 0; i < 6; i++) {
                Cell cell = headerRow.getCell(i);
                errorMsg = (cell == null || cell.getCellType() == CellType.BLANK) ? "file upload error due to row no " + i + 1 + " is empty" : "";

                if (errorMsg.isEmpty() && matched == true) {

                    //        System.out.println("Header value" + cell.toString() + "\n");
                    String cellName = cell.toString();
                    switch (cellName) {
//                        case "foodId":
//                            matched = true;
//                            break;
                        case "foodName":
                            matched = true;
                            break;
                        case "foodImage":
                            matched = true;
                            break;
                        case "foodDescription":
                            matched = true;
                            break;
                        case "foodCategory":
                            matched = true;
                            break;
                        case "foodPrice":
                            matched = true;
                            break;
                        case "foodDiscount":
                            matched = true;
                            break;
                        default:
                            matched = false;
                            break;

                    }
                } else {
                    matched = false;
                }
            }

            return matched;
        }
    }

