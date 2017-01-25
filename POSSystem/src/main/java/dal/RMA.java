package dal;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import list.ListRma;

/**
 * Created by rifat on 8/2/15.
 */
public class RMA {


    public String id;
    public String rmaName;
    public String rmaDays;
    public String rmaComment;
    public String creatorId;
    public String creatorName;
    public String date;

    public ObservableList<ListRma> rmaDetails = FXCollections.observableArrayList();


}