//
//  RestaurantDetailView.swift
//  TestAppcoda1
//
//  Created by sj on 2022/2/8.
//

import SwiftUI

struct RestaurantDetailView: View {
    
    var restaurant : Restaurant
    @State var showReview = false
    
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
                            Button(action: {
                                self.showReview.toggle()
                            }){
                                Image(systemName: "heart")
                                    .frame(minWidth: 0, maxWidth: 30, minHeight: 0, maxHeight: 30, alignment: .topTrailing)
                                    .padding()
                                    .font(.system(size: 30))
                                    .foregroundColor(.white)
                                    .padding(.top, 40)
                                    .tint(.green)
                            }
                        }
                        
                        VStack{
                            Text(self.showReview ? "true": "false" )
                                .bold()
                                .padding(.all ,5)
                            
                            Text(restaurant.type)
                                
                        }
                        .background(.black)
                        .foregroundColor(.white)
                        .padding(20)
                        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: . bottomLeading)
                        
                        if let rating = restaurant.rating{
                            VStack{
                                Image(rating.rawValue)
                                    .resizable()
                                    .frame(width: 40, height: 40)
                                    
                            }.padding(20)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: . bottomTrailing)
                        }
                        
                        
                    }
                Text("We covered a lot of things related to microapps architecture in Swift during the last month. I would love to finalize the series of posts by touching another essential edge of the approach: Dependency Injection. This week we will learn how to inject the dependencies into feature modules to improve testability and facilitate Xcode previews.")
                    .padding()
            }
        }
        .ignoresSafeArea()
        .overlay{
            showReview
                ? ReviewView(isShow: $showReview, restaurant: restaurant)
                
                : nil
        }
        .navigationBarHidden(false)        
        
    }
}

struct RestaurantDetailView_Previews: PreviewProvider {
    static var previews: some View {
        RestaurantDetailView(restaurant:  Restaurant(name: "CASK Pub and Kitchen", type: "Thai", location: "22 Charlwood Street London SW1V 2DY Pimlico", phone: "432-344050", description: "With kitchen serving gourmet burgers. We offer food every day of the week, Monday through to Sunday. Join us every Sunday from 4:30 – 7:30pm for live acoustic music!", image: "cask",
            isFavorite: false,rating: Rating.good))
    }
}
