//
//  SwiftUIView2.swift
//  MastingSwiftUICode
//
//  Created by jun shen on 2021/4/14.
//

import SwiftUI

struct LayoutUserInterface: View {
    
    @State var checked : Int  = 0
    
    var body: some View {
        VStack(spacing: 10){
            Text("LayoutUserInterface")
            
            Text("Choose Your Plan")
                .font(.system(size: 30, weight: .heavy, design: .rounded))
            HStack{
                HeaderView(title:"Pro", subTitile:"123",price:"19",checked:$checked).onTapGesture {
                        self.checked = self.checked + 1
                    }
                HeaderView(title:"Base", subTitile:"222",price:"9",checked:$checked)
            }

        }
    }
}

struct LayoutUserInterface_Previews: PreviewProvider {
    static var previews: some View {
        LayoutUserInterface()
    }
}

struct HeaderView: View {
 
    var title : String
    var subTitile : String
    var price : String
    @Binding var checked : Int
    
    var body: some View {
        VStack(alignment: .leading, spacing: 5){
            Text("\(title)")
                .font(.system(.largeTitle, design: .rounded))
                .fontWeight(.black)
            Text("$\(price)")
            .font(.system(size: 40, weight: .heavy, design: .rounded))
            Text("\(subTitile)")
                .font(.system(.largeTitle, design: .rounded))
                .fontWeight(.black)
        }.padding(32)
        .background(checked % 2 == 1 ? Color.blue : Color.gray)
        .cornerRadius(20)
    }
}
