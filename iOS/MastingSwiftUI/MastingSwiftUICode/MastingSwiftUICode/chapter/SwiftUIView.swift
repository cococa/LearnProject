//
//  SwiftUIView.swift
//  MastingSwiftUICode
//
//  Created by sj on 2023/6/30.
//

import SwiftUI

struct SwiftUIView: View {
    var body: some View {
        ForEach(1...10, id: \.self){
            Text("1")
        }
    }
}

struct SwiftUIView_Previews: PreviewProvider {
    static var previews: some View {
        SwiftUIView()
    }
}
