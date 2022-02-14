//
//  ReviewView.swift
//  TestAppcoda1
//
//  Created by sj on 2022/2/11.
//

import SwiftUI

struct ReviewView: View {
    
    @Binding var isShow : Bool
    var restaurant : Restaurant
    
    var body: some View {
       
        ZStack{
            Color.black
                .opacity(0.6)
                .ignoresSafeArea()
            
            VStack(alignment:.leading){
                
                HStack{
                    Spacer()
                    Button(action:{
                        withAnimation(.easeOut(duration: 0.3)){
                            self.isShow = false
                        }
                    }){
                        Image(systemName: "xmark")
                            .resizable()
                            .frame(width :30, height : 30)
                            .foregroundColor(.white)
                    }
                }
                .padding()
                
                Spacer()
            }
            .frame(minWidth: 0, maxWidth: .infinity,minHeight: 0, maxHeight: .infinity)
            
            
            VStack{
                
                ForEach(Rating.allCases ,id: \.self){ rating in
                        Button(action: {
                            
                            self.restaurant.rating = rating
                            self.isShow = false
                            
                        }){
                            HStack{
                                Image(rating.rawValue)
                                    .resizable()
                                    .frame(width: 60, height: 60, alignment: .center)
                                Text("\(rating.rawValue)")
                                
                                
                            }.foregroundColor(.white)
                            .font(.system(size: 20, weight: .regular, design: .rounded))
                            .offset(x : isShow ? 0 : 1000)
                            .animation(.easeOut, value: isShow)
                        }
                    
                }.padding()
                
            }
            
            
        }
        
    }
}

struct ReviewView_Previews: PreviewProvider {
    static var previews: some View {
        ReviewView(isShow: .constant(true), restaurant:  Restaurant(name: "CASK Pub and Kitchen", type: "Thai", location: "22 Charlwood Street London SW1V 2DY Pimlico", phone: "432-344050", description: "With kitchen serving gourmet burgers. We offer food every day of the week, Monday through to Sunday. Join us every Sunday from 4:30 – 7:30pm for live acoustic music!", image: "cask", isFavorite: false))
    }
}
