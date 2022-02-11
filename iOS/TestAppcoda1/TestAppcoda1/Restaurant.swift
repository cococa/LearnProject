//
//  Restaurant.swift
//  TestAppcoda1
//
//  Created by sj on 2022/1/29.
//

import Foundation




struct Restaurant{
    
    var name : String
    var type : String
    var location : String
    var image  : String
    var isFavorite : Bool
    var rating : Rating = .good
    
    init(name : String , type : String , location : String , image : String , isFavorite : Bool){
        self.name  = name
        self.type = type
        self.location = location
        self.image  = image
        self.isFavorite = isFavorite
    }
    
    init(){
        self.init(name: "", type: "", location: "", image: "", isFavorite: false)
    }
    
    
}