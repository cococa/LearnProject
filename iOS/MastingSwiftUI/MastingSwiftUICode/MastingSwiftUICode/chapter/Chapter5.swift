//
//  Chapter5.swift
//  MastingSwiftUICode
//
//  Created by sj on 2021/8/3.
//

import SwiftUI

struct Chapter5: View {
    var body: some View {
        NavigationView {
            ScrollView(.vertical,showsIndicators : false){
                VStack {
                    ScrollView(.horizontal,showsIndicators : false){
                        HStack {
                            CardView().frame(width: 300)
                            CardView().frame(width: 300)
                            CardView().frame(width: 300)
                            CardView().frame(width: 300)
                            CardView().frame(width: 300)
                            
                        }
                    }
                    CardView()
                    CardView()
                    CardView()
                    CardView()
                    CardView()

                }
            }
        }
//        .navigationBarTitle(Text("Title"))
    }
}

struct Chapter5_Previews: PreviewProvider {
    static var previews: some View {
        Chapter5()
    }
}
