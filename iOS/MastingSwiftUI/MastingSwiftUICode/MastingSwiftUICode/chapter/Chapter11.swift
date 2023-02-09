//
//  Chapter11.swift
//  MastingSwiftUICode
//
//  Created by sj on 2023/2/9.
//



import SwiftUI

var restaurants11 = [ Restaurant11(name: "Cafe Deadend", image: "cafedeadend"),
                      Restaurant11(name: "Homei", image: "homei"),
                      Restaurant11(name: "Teakha", image: "teakha")
]

struct Restaurant11 :Identifiable{
    var id = UUID()
    var name: String
    var image: String
}


struct RestaurantView11: View {

    var res : Restaurant11
    
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

struct Chapter11: View {
    var body: some View {
        NavigationView {
            List{
                ForEach(restaurants11, id: \.id){ res in
                    NavigationLink(destination:
                                    RestaurantDetailView(res: res)) {
                        
                        RestaurantView11(res: res)
                    }
                }
            }.listStyle(SidebarListStyle())
                .navigationBarTitle("Res", displayMode: .automatic)
        }
    }
}





struct Chapter11_Previews: PreviewProvider {
    static var previews: some View {
        Chapter11()
    }
}
