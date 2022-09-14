//
//  ContentView.swift
//  MastingSwiftUICode
//
//  Created by jun shen on 2021/4/14.
//

import SwiftUI

//struct ListData<Destination> : Destination : View {
//    var name : String?
//    var view : Destination
//}
//
//var list : [ListData] = [
////    ListData(name: "Chapter5 ", view: Chapter5())
//]



struct ContentView: View {
    var body: some View {
        NavigationView{
            VStack(alignment: .leading, spacing: 10.0){
                NavigationLink(
                    destination: LayoutUserInterface(),
                    label: {
                        Text("Layout User Interface")
                    }).navigationTitle("Layout User Interface")
                
                NavigationLink(
                    destination: Chapter5(),
                    label: {
                        Text("Chapter5 Understanding ScrollView and Building a Carousel UI")
                    }).navigationTitle("Chapter5")
                
                NavigationLink(
                    destination: Chapter6(),
                    label: {
                        Text("Chapter6 @State")
                    }).navigationTitle("Chapter6")
                
                NavigationLink(
                    destination: Chapter8(),
                    label: {
                        Text("Chapter8 Implementing Path and Shape for Line Drawing and Pie Charts")
                    }).navigationTitle("Chapter8")
                
                
                NavigationLink(
                    destination: Chapter9(),
                    label: {
                        Text("Chapter9 Anim")
                    }).navigationTitle("Chapter9")
                
                
            }
            
                
        }.navigationTitle("123")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
