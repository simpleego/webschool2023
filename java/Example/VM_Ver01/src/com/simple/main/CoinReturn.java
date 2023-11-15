package com.simple.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinReturn implements ActionListener {
    CoffeeVendingMachine vm;

    public CoinReturn(CoffeeVendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int money = vm.getInMoney();
        //  동전 종류별 반환 프로그램 구현
        int return500coin=0;
        int return100coin=0;
        int return50coin=0;
        int return10coin=0;

        return500coin = money / 500;
        money %= 500;
        return100coin = money / 100;
        money %= 100;
        return50coin = money / 50;
        money %= 50;
        return10coin = money /10;

        String returnMoney = "500원 : "+return500coin+
                "  100원 : "+return100coin+
                "  50원 : "+return50coin+
                "  10원 : "+return10coin;
        vm.message.setText(returnMoney);
    }
}
