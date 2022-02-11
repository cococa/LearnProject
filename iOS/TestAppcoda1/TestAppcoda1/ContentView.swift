//
//  ContentView.swift
//  TestAppcoda1
//
//  Created by sj on 2022/1/27.
//

import SwiftUI

struct ContentView: View {
    
    
    @State var restaurants = [
        Restaurant(name: "Cafe Deadend", type: "Coffee & Tea Shop", location:
    "Hong Kong", image: "cafedeadend", isFavorite: false),
        Restaurant(name: "Homei", type: "Cafe", location: "Hong Kong", image:
    "homei", isFavorite: false),
        Restaurant(name: "Teakha", type: "Tea House", location: "Hong Kong", image: "teakha", isFavorite: false),
        Restaurant(name: "Cafe loisl", type: "Austrian / Causual Drink", location: "Hong Kong", image: "cafeloisl", isFavorite: false),
        Restaurant(name: "Petite Oyster", type: "French", location: "Hong Kong"
        , image: "petiteoyster", isFavorite: false),
            Restaurant(name: "For Kee Restaurant", type: "Bakery", location: "HongKong", image: "forkee", isFavorite: false),
            Restaurant(name: "Po's Atelier", type: "Bakery", location: "Hong Kong"
        , image: "posatelier", isFavorite: false),
            Restaurant(name: "Bourke Street Backery", type: "Chocolate", location:
        "Sydney", image: "bourkestreetbakery", isFavorite: false),
            Restaurant(name: "Haigh's Chocolate", type: "Cafe", location: "Sydney"
        , image: "haigh", isFavorite: false),
            Restaurant(name: "Palomino Espresso", type: "American / Seafood", location: "Sydney", image: "palomino", isFavorite: false),
            Restaurant(name: "Upstate", type: "American", location: "New York", image: "upstate", isFavorite: false),
            Restaurant(name: "Traif", type: "American", location: "New York", image: "traif", isFavorite: false),
            Restaurant(name: "Graham Avenue Meats", type: "Breakfast & Brunch", location: "New York", image: "graham", isFavorite: false),
            Restaurant(name: "Waffle & Wolf", type: "Coffee & Tea", location: "NewYork", image: "waffleandwolf", isFavorite: false),
            Restaurant(name: "Five Leaves", type: "Coffee & Tea", location: "New York", image: "fiveleaves", isFavorite: false),
            Restaurant(name: "Cafe Lore", type: "Latin American", location: "New York", image: "cafelore", isFavorite: false),
            Restaurant(name: "Confessional", type: "Spanish", location: "New York"
        , image: "confessional", isFavorite: false),
            Restaurant(name: "Barrafina", type: "Spanish", location: "London", image: "barrafina", isFavorite: false),
            Restaurant(name: "Donostia", type: "Spanish", location: "London", image: "donostia", isFavorite: false),
            Restaurant(name: "Royal Oak", type: "British", location: "London", image: "royaloak", isFavorite: false),
            Restaurant(name: "CASK Pub and Kitchen", type: "Thai", location: "London", image: "cask", isFavorite: false)
        ]
    
        
    
    
    
    
    var body: some View {
        NavigationView {
            List{
                ForEach(restaurants.indices, id: \.self){ index in
                    NavigationLink(destination: {
                        RestaurantDetailView(restaurant: restaurants[index])
                    }){
                        BasicTextImageRow(restaurant: $restaurants[index])
                            .swipeActions(edge: .leading, allowsFullSwipe: false){
                                
                                Button{
                                    
                                }label: {
                                    Text("CALL")
                                }
                                                        
                            }
                            .swipeActions(edge: .trailing, allowsFullSwipe: true){
                                
                                Button{
                                    restaurants.remove(at: index)
                                }label: {
                                    Text("DELETE")
                                }
                                .tint(.red)
                            }
                    }
                    
                    
                    
                }
                .onDelete{ indexSet in
                    restaurants.remove(atOffsets: indexSet)
                }
                .listRowSeparator(.hidden)
            }
            .listStyle(.plain)
            .navigationTitle("FoodPin")
            
            .navigationBarTitleDisplayMode(.automatic)
        }
        
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        
        ContentView()
        
        ContentView()
            .preferredColorScheme(.dark)
    }
}

// MARK: sst
struct BasicTextImageRow: View {
    
    @State private var showOptions = false
    
    @Binding var restaurant : Restaurant
    
    

    var body: some View {
        HStack(alignment: .top, spacing: 20 ){
            
            Image(restaurant.image)
                .resizable()
                .frame(width: 120, height: 118)
                .cornerRadius(20)
            
//            Image("\(restaurant.rating.rawValue)")
//                .resizable()
//                .frame(width: 20, height: 18)
//                .cornerRadius(20)
            
            VStack(alignment:.leading) {
                Text(restaurant.name)
                    .foregroundColor(Color(setName: "titleBg"))
                    .font(.system(.title2, design: .rounded))
                
                Text(restaurant.type)
                    .font(.system(.body,design: .rounded))
                
                Text(restaurant.location)
                    .font(.system(.subheadline, design: .rounded))
                    .foregroundColor(.gray)
                
                if( restaurant.isFavorite ){
                    Image(systemName: "heart.fill")
                        .foregroundColor(.yellow)
                }
            }
        }
        .contextMenu{
            Button(action:{
                
            }){
                HStack{
                    Image(systemName: "phone")
                    Text("this is ContextMenu Button")
                }
            }
        }
        

        .onTapGesture {
            showOptions.toggle()
        }
        .actionSheet(isPresented: $showOptions){
            ActionSheet(title: Text("this is title"), message: nil, buttons: [
                .default(Text( restaurant.isFavorite ? "cancel favorites" : "click favorites")){
                    self.restaurant.isFavorite.toggle()
                },
                .cancel()
            ])
        }
    }
}
