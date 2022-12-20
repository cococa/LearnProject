//
//  ContentView.swift
//  CodeDesignWithiOS15
//
//  Created by sj on 2022/7/3.
//

import SwiftUI

struct ContentView: View {
    
    var body: some View {
        VStack(alignment: .center) {
            Image("aaa")
                .resizable()
                .background(.red)
                .cornerRadius(50)
                .frame(width: 50, height: 50)
            
            Text("SwiftUI for iOS 15")
                .font(.largeTitle)
                .fontWeight(.bold)
            Text("Placeholder")
            
        }
    } 
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
