//
//  RestaurantDetailView.swift
//  MastingSwiftUICode
//
//  Created by sj on 2023/2/9.
//

import SwiftUI

struct RestaurantDetailView: View {
    
    var res : Restaurant11
    
    var body: some View {
        VStack {
            Image("\(res.image)")
                .resizable()
                .frame(width: .infinity, height: 300)
                .aspectRatio(contentMode: .fit)
            Text(res.name)
            Spacer()
        }
    }
}

struct RestaurantDetailView_Previews: PreviewProvider {
    static var previews: some View {
        RestaurantDetailView(res: Restaurant11(name: "Cafe Deadend", image: "cafedeadend"))
    }
}
