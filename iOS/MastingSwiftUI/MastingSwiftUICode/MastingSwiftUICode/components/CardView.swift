//
//  CardView.swift
//  MastingSwiftUICode
//
//  Created by sj on 2021/8/3.
//

import SwiftUI

struct CardView: View {
    var body: some View {
        VStack {
            Image("swiftui-button")
                .resizable()
                .aspectRatio(contentMode: .fit)
            HStack {
                VStack(alignment: .leading){
                    Text("Swift-UI")
                        .font(.headline)
                        .foregroundColor(.secondary)
                    Text("Drawing a Border with Rounded Coriners")
                        .font(.title)
                        .fontWeight(.black)
                        .foregroundColor(.primary)
                        .lineLimit(3)
                    Text("Written by Cocoa")
                        .font(.caption)
                        .foregroundColor(.secondary)
                                    
                }
                .layoutPriority(10)
                Spacer()
            }.padding()
        }
        .cornerRadius(10)
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(Color(.sRGB,red: 150/255,green :150/255,blue:150/255,opacity: 0.1),lineWidth: 1)
        )
        .padding()
    }
}

struct CardView_Previews: PreviewProvider {
    static var previews: some View {
        CardView()
    }
}
