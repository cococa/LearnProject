//
//  ContentView.swift
//  MastingSwiftUICode
//
//  Created by jun shen on 2021/4/14.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView{
            VStack{
                NavigationLink(
                    destination: LayoutUserInterface(),
                    label: {
                        Text("Layout User Interface")
                    })
            }
                
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
