package assignment3;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
interface Enrollment {
    void addRecord(Record record);
    void deletedRecord(int index);
    Record getRecord(int index);
    ArrayList<Record> getRecords();
}
