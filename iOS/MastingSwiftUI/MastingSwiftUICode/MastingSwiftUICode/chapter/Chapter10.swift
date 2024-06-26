//
//  Chapter10.swift
//  MastingSwiftUICode
//
//  Created by sj on 2023/2/8.
//

import SwiftUI
var restaurants = [ Restaurant(name: "Cafe Deadend", image: "cafedeadend"), Restaurant(name: "Homei", image: "homei"),
Restaurant(name: "Teakha", image: "teakha"),
                    Restaurant(name: "Cafe Loisl", image: "cafeloisl"), Restaurant(name: "Petite Oyster", image: "petiteoyster"), Restaurant(name: "For Kee Restaurant", image: "forkeerestaurant"), Restaurant(name: "Po's Atelier", image: "posatelier"), Restaurant(name: "Bourke Street Bakery", image: "bourkestreetbakery"),
Restaurant(name: "Haigh's Chocolate", image: "haighschocolate"), Restaurant(name: "Palomino Espresso", image: "palominoespresso"), Restaurant(name: "Upstate", image: "upstate"),
Restaurant(name: "Traif", image: "traif"),
Restaurant(name: "Graham Avenue Meats And Deli", image: "grahamaven"),
Restaurant(name: "Waffle & Wolf", image: "wafflewolf"), Restaurant(name: "Five Leaves", image: "fiveleaves"), Restaurant(name: "Cafe Lore", image: "cafelore"), Restaurant(name: "Confessional", image: "confessional"), Restaurant(name: "Barrafina", image: "barrafina"), Restaurant(name: "Donostia", image: "donostia"), Restaurant(name: "Royal Oak", image: "royaloak"), Restaurant(name: "CASK Pub and Kitchen", image: "caskpubkitchen")
]

struct Restaurant :Identifiable{
    var id = UUID()
    var name: String
    var image: String
}


struct Chapter10: View {
    var body: some View {
        List{
            ForEach(restaurants, id: \.id){ res in
                RestaurantView(res: res)
            }
        }.listStyle(SidebarListStyle())
    }
}

struct Chapter10_Previews: PreviewProvider {
    static var previews: some View {
        Chapter10()
    }
}

struct RestaurantView: View {

    var res : Restaurant
    
    var body: some View {
        HStack {
            Image(res.image)
                .resizable()
                .frame(width: 40, height: 40)
                .cornerRadius(5)
            Text("item \(res.name)")
        }
    }
}
