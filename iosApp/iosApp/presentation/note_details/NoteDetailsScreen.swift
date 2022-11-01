//
//  NoteDetailsScreen.swift
//  iosApp
//
//  Created by Javier Gutiérrez Bravo on 1/11/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import core

struct NoteDetailsScreen: View {
    private var noteDataSource: NoteDataSource
    private var noteId: Int64? = nil
    @StateObject var viewModel = NoteDetailsViewModel(noteDataSource: nil)
    
    @Environment(\.presentationMode) var presentation
    
    init(noteDataSource: NoteDataSource, noteId: Int64? = nil) {
        self.noteDataSource = noteDataSource
        self.noteId = noteId
    }
    
    var body: some View {
        VStack {
            TextField("Enter a title...", text: $viewModel.noteTitle)
                .font(.title)
            TextField("Enter some content...", text: $viewModel.noteContent)
            Spacer()
        }.toolbar(content: {
            Button(action: {
                viewModel.saveNote {
                    self.presentation.wrappedValue.dismiss()
                }
            }) {
                Image(systemName: "checkmark")
            }
        })
        .padding()
        .background(Color(hex: viewModel.noteColor))
        .onAppear {
            viewModel.setParamsAndLoadNote(noteDataSource: noteDataSource, noteId: noteId)
        }
    }
}

struct NoteDetailsScreen_Previews: PreviewProvider {
    static var previews: some View {
        EmptyView()
    }
}
