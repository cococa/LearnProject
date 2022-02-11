//
//  UIColor.swift
//  TestAppcoda1
//
//  Created by sj on 2022/2/9.
//


import SwiftUI


extension Color{
    
//    convenience init(red : Int , green : Int , blue : Int){
//        let redValue = CGFloat(red) / 255.0
//        let greenValue = CGFloat(green) / 255.0
//        let blueValue = CGFloat(blue) / 255.0
//        self.init(red: redValue, green: greenValue, blue: blueValue)
//    }

    init(setName : String){
        self.init(setName, bundle: nil)
    }
    
    
}
