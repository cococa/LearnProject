//
//  RestaurantDetailView.swift
//  TestAppcoda1
//
//  Created by sj on 2022/2/8.
//

import SwiftUI

struct RestaurantDetailView: View {
    
    var restaurant : Restaurant
    
    
    var body: some View {
        ScrollView{
            VStack{
                Image(restaurant.image)
                    .resizable()
                    .scaledToFill()
                    .frame(width: 445)
                    .frame(minWidth: 0, maxWidth: .infinity)
                    
                    .overlay{
                        VStack{
                                Image(systemName: "heart")
                                    .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .topTrailing)
                                    .padding()
                                    .font(.system(size: 30))
                                    .foregroundColor(.white)
                                    .padding(.top, 40)
                                    .tint(.green)
                        }
                        
                        VStack{
                            Text(restaurant.name)
                                .bold()
                                .padding(.all ,5)
                            
                            Text(restaurant.type)
                                
                        }
                        .background(.black)
                        .foregroundColor(.white)
                        .padding(20)
                        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: . bottomLeading)
                        
                        
                    }
                Text("We covered a lot of things related to microapps architecture in Swift during the last month. I would love to finalize the series of posts by touching another essential edge of the approach: Dependency Injection. This week we will learn how to inject the dependencies into feature modules to improve testability and facilitate Xcode previews.")
                    .padding()
            }
        }
        .ignoresSafeArea()
//        .navigationBarHidden(true)
        
        
    }
}

struct RestaurantDetailView_Previews: PreviewProvider {
    static var previews: some View {
        RestaurantDetailView(restaurant: Restaurant(name: "Cafe Deadend", type: "Cafe", location: "Hong Kong",image: "cafedeadend",isFavorite: true))
    }
}
